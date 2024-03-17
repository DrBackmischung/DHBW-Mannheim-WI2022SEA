package de.wi22sea.demo.cats.logic;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.wi22sea.demo.cats.entity.Address;
import de.wi22sea.demo.cats.entity.Cat;
import de.wi22sea.demo.cats.entity.CatDAO;
import de.wi22sea.demo.cats.repo.AddressRepository;
import de.wi22sea.demo.cats.repo.CatRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class CatControllerTest {

    MockMvc mvc;

    @MockBean
    CatRepository repo;

    @MockBean
    AddressRepository addressRepository;

    @Autowired
    WebApplicationContext wac;

    JacksonTester<Cat> jt;
    JacksonTester<CatDAO> jtdao;

    static UUID uuid;

    @BeforeAll
    static void beforeAll() {
        uuid = new UUID(2, 2);
    }

    @BeforeEach
    void beforeEach() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void testGetAll() throws Exception {
        when(repo.findAll()).thenReturn(new ArrayList<Cat>());
        mvc.perform(get("/cats"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
    	Cat c = new Cat("", "", new Address("", "", "", ""), "", 0);
    	c.setId(uuid);
    	
        when(repo.findById(uuid)).thenReturn(Optional.of(c));
        mvc.perform(get("/cats/"+uuid)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetByIdError() throws Exception {
        mvc.perform(get("/cats/"+uuid)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
