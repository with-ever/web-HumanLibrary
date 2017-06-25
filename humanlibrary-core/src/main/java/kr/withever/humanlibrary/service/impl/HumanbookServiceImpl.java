package kr.withever.humanlibrary.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.repo.HumanbookRepository;
import kr.withever.humanlibrary.repo.UserRoleRepository;
import kr.withever.humanlibrary.service.HumanbookService;

@Service
@Transactional
public class HumanbookServiceImpl implements HumanbookService {

	@Autowired
	private HumanbookRepository humanbookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	
	@Override
	public Long createHumanbook(Humanbook humanbook){
		humanbook.setState(HumanbookState.WAITING);
		return this.humanbookRepository.createHumanbook(humanbook);
	}

	@Override
	public Humanbook retrieveHumanbook(Long id){
		Humanbook humanbook = this.humanbookRepository.retrieveHumanbook(id);
		if (humanbook.getUser() != null) humanbook.setUser(User.decryptUser(this.userRepository.retrieveUser(humanbook.getUser().getUserId())));

		// @TODO error code update
		// if(humanbook == null) throw new HumanLibraryNotFoundException(ExceptionType.US10002, String.valueOf(id), "success");
		return humanbook;
	}

	@Override
	public HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search) {
		return decryptHumanbookUser(this.humanbookRepository.retrieveHumanbooksBySearch(search));
	}
	
	@Override
	public HumanbookSearch retrieveHumanbooksByCategory(HumanbookSearch search){
		return decryptHumanbookUser(this.humanbookRepository.retrieveHumanbooksByCategory(search));
	}
	
	@Override
	public void modifyHumanbook(Humanbook humanbook){
		// @TODO humanbook 수정 refactoring.
		Humanbook previousHumanbook = this.humanbookRepository.retrieveHumanbook(humanbook.getId());
		previousHumanbook.setUpdatedHumanbook(humanbook);
		this.humanbookRepository.modifyHumanbook(previousHumanbook);
	}
	
	@Override
	public void modifyHumanbookState(Long id, HumanbookState state) {
		this.humanbookRepository.modifyHumanbookState(id, state);
	}
	
	@Override
	public void rejectHumanbookRegister(Long id) {
		this.humanbookRepository.modifyHumanbookState(id, HumanbookState.REJECT);
	}
	
	@Override
	public void acceptHumanbookRegister(Long id) {
		this.humanbookRepository.modifyHumanbookState(id, HumanbookState.ACCEPT);
		Humanbook humanbook = this.humanbookRepository.retrieveHumanbook(id);
		// 휴먼북 사용자에게 권한 부여.
		Set<String> roles = this.userRoleRepository.retrieveUserRoles(humanbook.getUser().getUserId());
        if (!roles.contains(RoleType.HUMAN_BOOK.getName())) {
            this.userRoleRepository.createUserRole(id, RoleType.HUMAN_BOOK.getName());
        }
	}

    @Override
    public void cancelHumanbook(Long id) {
        this.humanbookRepository.modifyHumanbookState(id, HumanbookState.CANCEL);
    }

    @Override
	public void removeHumanbook(Long id){
		this.humanbookRepository.removeHumanbook(id);
	}

	private HumanbookSearch decryptHumanbookUser(HumanbookSearch search) {
		List<Humanbook> humanbooks = search.getResults();
		for (int index = 0; index < humanbooks.size(); index++) {
			if (humanbooks.get(index).getUser() != null) humanbooks.get(index).setUser(User.decryptUser(humanbooks.get(index).getUser()));
		}
		search.setResults(humanbooks);
		return search;
	}
}
