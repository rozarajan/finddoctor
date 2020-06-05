package com.perfm.finddoctorapp.messageservice

import com.perfm.finddoctorapp.model.Doctor
import com.perfm.finddoctorapp.service.DoctorService
import com.perfm.finddoctorapp.service.DoctorServiceImpl
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.util.concurrent.CountDownLatch

@Service
class MessageConsumer(private val doctorServiceImpl: DoctorServiceImpl){

    val latch = CountDownLatch(3)

    val bookLatch = CountDownLatch(1)

    @KafkaListener(topics = ["\${doctor.topic.name}"], containerFactory = "doctorKafkaListenerContainerFactory")
    fun doctorListener(doctor: Doctor) {
        println("Recieved message: $doctor")
        val savedDoctorDetails : Doctor = doctorServiceImpl.insert(doctor)
        println("Doctor details persisted in MongoDB: $savedDoctorDetails")
        bookLatch.countDown()
    }
}