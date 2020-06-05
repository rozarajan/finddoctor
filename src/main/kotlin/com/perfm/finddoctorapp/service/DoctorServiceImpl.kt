package com.perfm.finddoctorapp.service

import com.perfm.finddoctorapp.model.Doctor
import com.perfm.finddoctorapp.repository.DoctorRepository
import com.perfm.finddoctorapp.repository.HospitalDetailsRepository
import com.perfm.finddoctorapp.util.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class DoctorServiceImpl(val doctorRepository: DoctorRepository, val hospitalDetailsRepository: HospitalDetailsRepository):BasicCrud<String, Doctor> {
    override fun getAll(pageable: Pageable): Page<Doctor> {
        return doctorRepository.findAll(pageable)
    }

    override fun getById(id: String): Optional<Doctor> {
        return doctorRepository.findById(id)
    }

    override fun insert(obj: Doctor): Doctor = doctorRepository.insert(obj.apply { this.hospitalAffiliation.hospitalDetails=hospitalDetailsRepository.findById(obj.hospitalAffiliation.hospitalDetails.id).get()})


    override fun update(obj: Doctor): Doctor {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Doctor> {
        TODO("Not yet implemented")
    }

    fun deleteAllDoctorCollections(){
        doctorRepository.deleteAll()
    }




}