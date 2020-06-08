package com.perfm.finddoctorapp

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import com.perfm.finddoctorapp.model.HospitalDetails
import org.springframework.stereotype.Component

@Component
class TestHelper {

    fun getHospitalDetailH1003(): HospitalDetails = HospitalDetails(id = "H1003", hospitalName = "Redwood City Medical Center", city = "CA", country = "USA")
    fun getHospitalDetailH1004(): HospitalDetails = HospitalDetails(id = "H1004", hospitalName = "Indian Hill Medical Offices", city = "CA", country = "USA")
    fun getHospitalDetailH1005(): HospitalDetails = HospitalDetails(id = "H1005", hospitalName = "Bv Camarillo Medical Offices", city = "CA", country = "USA")

    fun getHospitalDetailsList(): List<HospitalDetails>{
        val h1 = HospitalDetails(id = "H1000", hospitalName = "Santa Clara Homestead Med Center", city = "CA", country = "USA")
        val h2 = HospitalDetails(id = "H1001", hospitalName = "San Jose Medical Center", city = "CA", country = "USA")
        val h3 = HospitalDetails(id = "H1002", hospitalName = "Fremont Medical Center", city = "CA", country = "USA")
        val hospitalDetails = listOf(
                h1,h2,h3,getHospitalDetailH1003(), getHospitalDetailH1004(),getHospitalDetailH1005()
        )
        return hospitalDetails
    }

    fun requestJson():String{
        val h1 = HospitalDetails(id = "H1000", hospitalName = "Santa Clara Homestead Med Center", city = "CA", country = "USA")
        val mapper = ObjectMapper()
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        val ow: ObjectWriter = mapper.writer().withDefaultPrettyPrinter()
        return ow.writeValueAsString(h1)
    }

}