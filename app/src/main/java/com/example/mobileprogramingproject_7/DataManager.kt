package com.example.mobileprogramingproject_7

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class DataManager {
    val wheelchair: ArrayList<DataWheelchair> = arrayListOf()
    val center: ArrayList<DataCenter> = arrayListOf()
    val scope = CoroutineScope(Dispatchers.IO)
    val urlWheelchair = "http://api.data.go.kr/openapi/tn_pubr_public_electr_whlchairhgh_spdchrgr_api?serviceKey=6mHJyQoASvnGKqv3mTvlcq5GldACNku2xT2pOH0l6kqSEkSnI572eSVQKrqThotBKF%2FDGjb4jHUrKhxcP%2FWqYA%3D%3D" //open api endformat + serviceKey
    val urlCenter = "http://api.data.go.kr/openapi/tn_pubr_public_tfcwker_mvmn_cnter_api?serviceKey=6mHJyQoASvnGKqv3mTvlcq5GldACNku2xT2pOH0l6kqSEkSnI572eSVQKrqThotBKF%2FDGjb4jHUrKhxcP%2FWqYA%3D%3D" //open api endformat + serviceKey

    init {
        initData()
    }

    private fun initData() {
        //open api 통해서 xml data가져온 후 list에 저장
        scope.launch {
            wheelchairLaunch()
        }
        scope.launch {
            centerLaunch()
        }
    }

    private fun wheelchairLaunch() {
        val doc = Jsoup.connect(urlWheelchair).parser(Parser.xmlParser()).get()
        val items = doc.select("item")
        for(item in items) { //parsing
            wheelchair.add(DataWheelchair(
                item.select("fcltyNm").text(), item.select("rdnmadr").text(), item.select("institutionPhoneNumber").text(),
                item.select("instlLcDesc").text(), item.select("weekdayOperOpenHhmm").text(), item.select("weekdayOperColseHhmm").text(),
                item.select("satOperOperOpenHhmm").text(), item.select("satOperCloseHhmm").text(), item.select("holidayOperOpenHhmm").text(),
                item.select("holidayCloseOpenHhmm").text(), item.select("latitude").text(), item.select("longitude").text()))
        }
    }
    private fun centerLaunch() {
        val doc = Jsoup.connect(urlCenter).parser(Parser.xmlParser()).get()
        val items = doc.select("item")
        for(item in items) { //parsing
            center.add(DataCenter(
                item.select("tfcwkerMvmnCnterNm").text(), item.select("rdnmadr").text(), item.select("phoneNumber").text(),
                item.select("weekdayRceptOpenHhmm").text(), item.select("weekdayRceptColseHhmm").text(), item.select("wkendRceptOpenHhmm").text(),
                item.select("wkendRceptCloseHhmm").text(), item.select("weekdayOperOpenHhmm").text(), item.select("weekdayOperColseHhmm").text(),
                item.select("wkendOperOpenHhmm").text(), item.select("wkendOperCloseHhmm").text(), item.select("useTrget").text(),
                item.select("useCharge").text(), item.select("insideOpratArea").text(), item.select("outsideOpratArea").text(),
                item.select("latitude").text(), item.select("longitude").text()))
        }
    }
}
