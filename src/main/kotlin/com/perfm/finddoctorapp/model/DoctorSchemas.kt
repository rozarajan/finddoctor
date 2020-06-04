package com.perfm.finddoctorapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document data class Doctor( @Id val id: String,
                             val firstName : String,
                             val lastName : String,
                             val professionalStatement : String,
                             val practicingFrom: Date,
                             var specialization: Specialization,
                             var doctorSpecialization: DoctorSpecialization,
                             var qualification: Qualification,
                             var hospitalAffiliation: HospitalAffiliation
)

data class Specialization(val id : String, val specializationName: String)
data class DoctorSpecialization(val id:String, val doctorId: String, val specializationId: String)
data class Qualification(val id:String,val doctorId:String,val qualificationName:String,val institutionName:String,val procurementYear:Date)
data class HospitalAffiliation(val id:String,val doctorId:String,val hospitalName:String,val city:String,val country:String,val startDate:String,val endDate:String)

@Document data class HospitalDetails(@Id val id:String, val hospitalName:String,val city:String,val country:String)
