package com.perfm.finddoctorapp.messageservice


import com.perfm.finddoctorapp.model.Doctor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFutureCallback

@Service
class MessageProducer {

    @Autowired
    private var doctorKafkaTemplate: KafkaTemplate<String, Doctor>? = null

    @Value(value = "\${doctor.topic.name}")
    private val doctorTopicName: String? = null

    fun sendMessage(doctor: Doctor) {
        val future = doctorKafkaTemplate!!.send(doctorTopicName!!, doctor)
        future.addCallback(object : ListenableFutureCallback<SendResult<String?, Doctor?>?> {
            override fun onSuccess(result: SendResult<String?, Doctor?>?) {
                println("Sent message=[$doctor] with offset=[" + result!!.recordMetadata
                        .offset() + "]")
            }

            override fun onFailure(ex: Throwable) {
                println("Unable to send message=[" + doctor + "] due to : " + ex.message)
            }
        })
    }

    fun sendDoctorDetails(doctor: Doctor) : String {
        println("Inside sendDoctorDetails : Doctor details $doctor")
        doctorKafkaTemplate!!.send(doctorTopicName!!, doctor)
        return "success"
    }
}