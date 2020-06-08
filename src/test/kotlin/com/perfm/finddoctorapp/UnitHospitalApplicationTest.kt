package com.perfm.finddoctorapp


import com.perfm.finddoctorapp.service.HospitalService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.nio.charset.Charset


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UnitHospitalApplicationTest {

    private val URI = "/api/hospital"

    @Autowired private lateinit  var testHelper: TestHelper

    @Autowired
    private lateinit var wac: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeAll
    fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }

    @MockBean
    private lateinit var hospitalService: HospitalService

    @Test
    @Throws(Exception::class)
    fun testGetById() {
        val APPLICATION_JSON_UTF8 = MediaType(MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype, Charset.forName("utf8"))
        println(">> testUpdateHospitalDetails")
        val hospitalDetailH1003 = testHelper.getHospitalDetailH1004()
        given(hospitalService.update(hospitalDetailH1003)).willReturn(hospitalDetailH1003)
        // Get Hospital Details
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/hospital/update").contentType(APPLICATION_JSON_UTF8)
                        .content(testHelper.requestJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.hospitalName").value("Redwood City Medical Center"))}
    }

    @Test
    @Throws(Exception::class)
    fun testUpdate(){
        val APPLICATION_JSON_UTF8 = MediaType(MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype, Charset.forName("utf8"))
        println(">> testUpdateHospitalDetails")
        val hospitalDetailH1003 = testHelper.getHospitalDetailH1004()
        given(hospitalService.update(hospitalDetailH1003)).willReturn(hospitalDetailH1003)
        // Get Hospital Details
        this. mockMvc
                .perform(MockMvcRequestBuilders.put("/api/hospital/update").contentType(APPLICATION_JSON_UTF8)
                        .content(testHelper.requestJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.hospitalName").value("Redwood City Medical Center"))
    }
}