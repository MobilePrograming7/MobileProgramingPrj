package com.example.mobileprogramingproject_7

import java.io.Serializable

data class DataWheelchair //전국전동휠체어급속충전기표준데이터
    (val fcltyNm:String, val rdnmadr:String, val institutionPhoneNumber: String, val instlLcDesc:String,
     val weekdayOperOpenHhmm:String, val weekdayOperColseHhmm:String, val satOperOperOpenHhmm:String,
     val satOperCloseHhmm:String, val holidayOperOpenHhmm:String, val holidayCloseOpenHhmm:String,
     val latitude:String, val longitude:String)
    :Serializable

//관리기관, 도로명주소, 전화번호, 설치장소,
//평일운영시작시간, 평일운영마감시간, 토요일운영시작시간,
//토요일운영마감시간, 공휴일운영시작시간, 공휴일운영마감시간,
//위도, 경도

/* DataExample - https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15034533
<item>
    <fcltyNm>용산행복장애인자립생활센터</fcltyNm>
    <ctprvnNm>서울특별시</ctprvnNm>
    <signguNm>용산구</signguNm>
    <signguCode>11170</signguCode>
    <rdnmadr>서울특별시 용산구 원효로89길 31</rdnmadr>
    <lnmadr/>
    <latitude>37.54074494</latitude>
    <longitude>126.9673582</longitude>
    <instlLcDesc>센터 1층</instlLcDesc>
    <weekdayOperOpenHhmm>09:00</weekdayOperOpenHhmm>
    <weekdayOperColseHhmm>18:00</weekdayOperColseHhmm>
    <satOperOperOpenHhmm>00:00</satOperOperOpenHhmm>
    <satOperCloseHhmm>00:00</satOperCloseHhmm>
    <holidayOperOpenHhmm>00:00</holidayOperOpenHhmm>
    <holidayCloseOpenHhmm>00:00</holidayCloseOpenHhmm>
    <smtmUseCo>2</smtmUseCo>
    <airInjectorYn>Y</airInjectorYn>
    <moblphonChrstnYn>Y</moblphonChrstnYn>
    <institutionNm>용산행복장애인자립생활센터</institutionNm>
    <institutionPhoneNumber>02-704-0420</institutionPhoneNumber>
    <referenceDate>2021-09-15</referenceDate>
    <insttCode>3020000</insttCode>
</item>
*/