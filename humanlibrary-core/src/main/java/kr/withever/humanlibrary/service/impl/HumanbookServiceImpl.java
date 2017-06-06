package kr.withever.humanlibrary.service.impl;

import java.util.HashSet;
import java.util.Set;

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
	private UserRoleRepository userRoleRepository;

	
	@Override
	public Long createHumanbook(Humanbook humanbook){
		humanbook.setState(HumanbookState.WAITING);
		return this.humanbookRepository.createHumanbook(humanbook);
	}

	@Override
	public Humanbook retrieveHumanbook(Long id){
		Humanbook humanbook = this.humanbookRepository.retrieveHumanbook(id);
		
		// @TODO error code update
		// if(humanbook == null) throw new HumanLibraryNotFoundException(ExceptionType.US10002, String.valueOf(id), "success");
		return humanbook;
	}

	@Override
	public HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search) {
		return this.humanbookRepository.retrieveHumanbooksBySearch(search);
	}
	
	@Override
	public HumanbookSearch retrieveHumanbooksByCategory(HumanbookSearch search){
		return this.humanbookRepository.retrieveHumanbooksByCategory(search);
	}
	
	@Override
	public void modifyHumanbook(Humanbook humanbook){
		// @TODO humanbook 수정 refactoring.
		this.humanbookRepository.modifyHumanbook(humanbook);
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
		String humanbookRole = RoleType.HUMAN_BOOK.getName();
		Set<String> newRole = new HashSet<>();
		newRole.add(humanbookRole);
		this.humanbookRepository.modifyHumanbookState(id, HumanbookState.ACCEPT);
		this.userRoleRepository.createUserRoles(id, newRole);
		//User role에 humanbook 추가해주기
	}
	
	@Override
	public void removeHumanbook(Long id){
		this.humanbookRepository.removeHumanbook(id);
		this.userRoleRepository.removeUserRole(id, RoleType.HUMAN_BOOK.getName());
		//User role에 humanbook 제거
	}
}
