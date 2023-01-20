package com.food.foodsafetykoreaapi.domain.api.dto;

import lombok.ToString;

/**
 * PRDLST_REPORT_NO : 20030415157354
 * PRMS_DT : 20180808
 * LCNS_NO : 20030415157
 * PRDLST_NM : 101 후코이단
 * BSSH_NM : 주식회사 노바렉스
 * PRDLST_DCNM : 기타가공품
 * RAWMTRL_NM : 양배추분말,L-라이신염산염,효모추출물,L-글루타민,밀싹분말,상황버섯추출물분말,알로에베라겔농축분말,볶은현미분말,미역귀추출분말,덱스트린,귀리식이섬유,산화아연,L-아르지닌,파라다이스넛추출물분말,차가버섯자실체추출물
 */

/**
 * @author gutenlee
 * @since 2023/01/20
 */
@ToString
public class C002ResponseData {
    private String PRDLST_REPORT_NO;
    private String PRMS_DT;
    private String LCNS_NO;
    private String PRDLST_NM;
    private String BSSH_NM;
    private String PRDLST_DCNM;
    private String RAWMTRL_NM;
}
