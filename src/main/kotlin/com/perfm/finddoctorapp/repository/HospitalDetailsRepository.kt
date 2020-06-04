package com.perfm.finddoctorapp.repository

import com.perfm.finddoctorapp.model.HospitalDetails
import org.springframework.data.mongodb.repository.MongoRepository

interface HospitalDetailsRepository : MongoRepository<HospitalDetails,String>