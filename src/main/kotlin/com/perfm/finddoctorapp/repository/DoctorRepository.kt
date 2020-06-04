package com.perfm.finddoctorapp.repository

import com.perfm.finddoctorapp.model.Doctor
import org.springframework.data.mongodb.repository.MongoRepository

interface DoctorRepository : MongoRepository<Doctor,String>