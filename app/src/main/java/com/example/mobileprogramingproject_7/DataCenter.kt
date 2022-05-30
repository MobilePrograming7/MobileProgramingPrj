package com.example.mobileprogramingproject_7

import java.io.Serializable

data class DataCenter //전국교통약자이동지원센터정보표준데이터
    (val tfcwkerMvmnCnterNm:String, val rdnmadr:String, val phoneNumber: String, val weekdayRceptOpenHhmm:String,
     val weekdayRceptColseHhmm:String, val wkendRceptOpenHhmm:String, val wkendRceptCloseHhmm:String, val weekdayOperOpenHhmm:String,
     val weekdayOperColseHhmm:String, val wkendOperOpenHhmm:String, val wkendOperCloseHhmm:String, val useTrget:String,
     val useCharge:String, val insideOpratArea:String, val outsideOpratArea:String, val latitude:String, val longitude:String)
    :Serializable

//관리기관, 도로명주소, 전화번호, 평일예약접수운영시작시간,
//평일예약접수운영마감시간, 주말예약접수운영시작시간, 주말예약접수운영마감시간, 평일차량운행시작시간,
//평일차량운행마감시간, 주말차량운행시작시간, 주말차량운행마감시간, 차량이용대상,
//차량이용요금, 차량관내운행지역, 차량관외운행지역, 위도, 경도

/* DataExample - https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15028207
<item>
    <tfcwkerMvmnCnterNm>완도군 개인택시 지부(위탁)</tfcwkerMvmnCnterNm>
    <rdnmadr>완도군 완도읍 개포로130번길 15</rdnmadr>
    <lnmadr>전라남도 완도군 완도읍 군내리 1233-5</lnmadr>
    <latitude>34.318879</latitude>
    <longitude>126.7445340567</longitude>
    <carHoldCo>4</carHoldCo>
    <carHoldKnd>승합</carHoldKnd>
    <slopeVhcleCo>4</slopeVhcleCo>
    <liftVhcleCo>0</liftVhcleCo>
    <rceptPhoneNumber>1899-1110</rceptPhoneNumber>
    <rceptItnadr>전남광역콜 앱</rceptItnadr>
    <appSvcNm/>
    <weekdayRceptOpenHhmm>08:00</weekdayRceptOpenHhmm>
    <weekdayRceptColseHhmm>23:00</weekdayRceptColseHhmm>
    <wkendRceptOpenHhmm>08:00</wkendRceptOpenHhmm>
    <wkendRceptCloseHhmm>23:00</wkendRceptCloseHhmm>
    <weekdayOperOpenHhmm>08:00</weekdayOperOpenHhmm>
    <weekdayOperColseHhmm>23:00</weekdayOperColseHhmm>
    <wkendOperOpenHhmm>08:00</wkendOperOpenHhmm>
    <wkendOperCloseHhmm>23:00</wkendOperCloseHhmm>
    <beffatResvePd>1일전</beffatResvePd>
    <useLmtt/>
    <insideOpratArea/>
    <outsideOpratArea/>
    <useTrget>장애정도가 심한 장애인,임산부,사고질병 등 일시적 휄체어 이용자,등</useTrget>
    <useCharge>500원</useCharge>
    <institutionNm>완도군</institutionNm>
    <phoneNumber>061-550-5580</phoneNumber>
    <referenceDate>2020-01-01</referenceDate>
    <insttCode>4990000</insttCode>
</item>
*/