package com.perfm.finddoctorapp.controller

import com.perfm.finddoctorapp.messageservice.MessageProducer
import com.perfm.finddoctorapp.model.HospitalDetails
import com.perfm.finddoctorapp.service.HospitalService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/hospital")
class HospitalController(private val messageProducer: MessageProducer, private val hospitalService: HospitalService) {

    //
    //@GetMapping("/all") fun getAllDoctors(pageable: Pageable) : Page<Doctor> = doctorServiceImpl.getAll(pageable)
    //@PostMapping("/add") fun insertDoctorDetails(@RequestBody doctor: Doctor) : Doctor = doctorServiceImpl.insert(doctor)
    //@DeleteMapping("/delete/{id}") fun deleteDoctorById(@PathVariable id : String): Optional<Doctor> = doctorServiceImpl.deleteById(id)

    @GetMapping("/{id}") fun getHospitalDetailById(@PathVariable id: String) : Optional<HospitalDetails> = hospitalService.getById(id)
    @GetMapping("/all") fun getAllHospitalDetails(pageable: Pageable): Page<HospitalDetails> = hospitalService.getAll(pageable)
    @PostMapping("/add") fun saveHospitalDetails(@RequestBody hospitalDetails: HospitalDetails) : HospitalDetails = hospitalService.insert(hospitalDetails)
    @DeleteMapping("/delete/{id}") fun deleteHospitalDetalsById(@PathVariable id : String) : Optional<HospitalDetails> = hospitalService.deleteById(id)
    @PutMapping("/update") fun updateHospitalDetails(@RequestBody hospitalDetails: HospitalDetails): HospitalDetails = hospitalService.update(hospitalDetails)

}