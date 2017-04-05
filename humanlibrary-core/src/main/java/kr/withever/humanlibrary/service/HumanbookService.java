package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;

/**
 * Created by youngjinkim on 2017. 3. 16..
 */
public interface HumanbookService {

	Long createHumanbook(Humanbook humanBook);
    
	Humanbook retrieveHumanbookByUserId(String userId);

    Humanbook retrieveHumanbook(Long id);

    HumanbookSearch retrieveHumanbooksBySearch(HumanbookSearch search);
    
    HumanbookSearch retrieveHumanbooksByCategory(HumanbookSearch search);
    
    HumanbookSearch retrieveHumanbooksBySubCategory(HumanbookSearch search);

    void modifyHumanbook(Humanbook humanbook);

    void modifyHumanbookState(Long id, HumanbookState state);

    void rejectHumanbookRegister(Long id);

    void acceptHumanbookRegister(Long id);
    
    void removeHumanbook(Long id);
    
}
