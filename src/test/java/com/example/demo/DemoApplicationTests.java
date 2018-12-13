package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TripRepository tripRepository;

    @Before
    public void deleteAllBeforeTests() throws Exception {
        customerRepository.deleteAll();
        tripRepository.deleteAll();
    }

    @Test
    public void shouldReturnCustomerRepositoryIndex() throws Exception {

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$._links.customers").exists());
    }

    @Test
    public void shouldReturnTripRepositoryIndex() throws Exception {

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$._links.trips").exists());
    }

    @Test
    public void shouldCreateCustomersEntity() throws Exception {

        mockMvc.perform(post("/customers").content(
                "{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
                status().isCreated()).andExpect(
                header().string("Location", Matchers.containsString("customers/")));
    }

    @Test
    public void shouldCreateTripEntity() throws Exception {

        mockMvc.perform(post("/trips").content(
                "{\"destination\": \"Karaiby\"}")).andExpect(
                status().isCreated()).andExpect(
                header().string("Location", Matchers.containsString("trips/")));
    }

    @Test
    public void shouldRetrieveCustomerEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/customers").content(
                "{\"firstName\": \"Adam\", \"lastName\":\"Mialczynski\"}")).andExpect(
                status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.firstName").value("Adam")).andExpect(
                jsonPath("$.lastName").value("Mialczynski"));
    }

    @Test
    public void shouldRetrieveTripEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/trips").content(
                "{\"destination\": \"Karaiby\"}")).andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.destination").value("Karaiby"));
    }

    @Test
    public void shouldQueryCustomerEntity() throws Exception {

        mockMvc.perform(post("/customers").content(
                "{ \"firstName\": \"Adam\", \"lastName\":\"Kowalski\"}")).andExpect(
                status().isCreated());

        mockMvc.perform(
                get("/customers/search/findByLastName?name={name}", "Kowalski")).andExpect(
                status().isOk()).andExpect(
                jsonPath("$._embedded.customers[0].firstName").value(
                        "Adam"));
    }

    @Test
    public void shouldQueryTripEntity() throws Exception {

        mockMvc.perform(post("/trips").content(
                "{ \"destination\": \"Karaiby\"}")).andExpect(status().isCreated());

        mockMvc.perform(
                get("/trips/search/findByDestination?destination={destination}", "Karaiby")).andExpect(
                status().isOk());
    }

    @Test
    public void shouldUpdateCustomerEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/customers").content(
                "{\"firstName\": \"Adam\", \"lastName\":\"Kowalski\"}")).andExpect(
                status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(put(location).content(
                "{\"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}")).andExpect(
                status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.firstName").value("Bilbo")).andExpect(
                jsonPath("$.lastName").value("Baggins"));
    }

    @Test
    public void shouldUpdateTripEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/trips").content(
                "{\"destination\": \"Karaiby\"}")).andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(put(location).content(
                "{\"destination\": \"Radom\"}")).andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.destination").value("Radom"));
    }

    @Test
    public void shouldPartiallyUpdateEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/customers").content(
                "{\"firstName\": \"Kamil\", \"lastName\":\"Kowalski\"}")).andExpect(
                status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(
                patch(location).content("{\"firstName\": \"Adam\"}")).andExpect(
                status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.firstName").value("Adam")).andExpect(
                jsonPath("$.lastName").value("Kowalski"));
    }

    @Test
    public void shouldDeleteCustomerEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/customers").content(
                "{ \"firstName\": \"Adam\", \"lastName\":\"Kowalski\"}")).andExpect(
                status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(delete(location)).andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteTripEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/trips").content(
                "{ \"destination\": \"Radom\"}")).andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(delete(location)).andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }

}

