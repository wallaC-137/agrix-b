package com.betrybe.agrix.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * The type Person service test.
 */
@SpringBootTest
public class PersonServiceTest {

  /**
   * The Person service.
   */
  @Autowired
  PersonService personService;

  /**
   * The Person repository.
   */
  @MockBean
  PersonRepository personRepository;

  /**
   * Test create.
   */
  @Test
  public void testCreate() {
    Person person = new Person();
    person.setUsername("test");
    person.setPassword("password");
    person.setRole(Role.USER);

    Person personReturn = new Person();
    personReturn.setId(1L);
    personReturn.setUsername(person.getUsername());
    personReturn.setPassword(person.getPassword());
    personReturn.setRole(person.getRole());

    Mockito.when(personRepository.save(Mockito.any(Person.class)))
        .thenReturn(personReturn);

    Person createdPerson = personService.create(person);

    Mockito.verify(personRepository).save(Mockito.any(Person.class));

    assertEquals(1L, createdPerson.getId());
    assertEquals(person.getUsername(), createdPerson.getUsername());
    assertEquals(person.getPassword(), createdPerson.getPassword());
    assertEquals(person.getRole(), createdPerson.getRole());
  }

  /**
   * Gets person by username.
   */
  @Test
  public void getPersonByUsername() {
    Person person = new Person();
    person.setUsername("test");
    person.setPassword("password");
    person.setRole(Role.USER);

    Person personReturn = new Person();
    personReturn.setId(1L);
    personReturn.setUsername(person.getUsername());
    personReturn.setPassword(person.getPassword());
    personReturn.setRole(person.getRole());

    Mockito.when(personRepository.findByUsername(Mockito.any(String.class)))
        .thenReturn(java.util.Optional.of(personReturn));

    Person createdPerson = personService.getPersonByUsername(person.getUsername());

    Mockito.verify(personRepository).findByUsername(Mockito.any(String.class));

    assertEquals(1L, createdPerson.getId());
    assertEquals(person.getUsername(), createdPerson.getUsername());
    assertEquals(person.getPassword(), createdPerson.getPassword());
    assertEquals(person.getRole(), createdPerson.getRole());
  }

  /**
   * Gets person by id.
   */
  @Test
  public void getPersonById() {
    Person person = new Person();
    person.setUsername("test");
    person.setPassword("password");
    person.setRole(Role.USER);

    Person personReturn = new Person();
    personReturn.setId(1L);
    personReturn.setUsername(person.getUsername());
    personReturn.setPassword(person.getPassword());
    personReturn.setRole(person.getRole());

    Mockito.when(personRepository.findById(Mockito.any(Long.class)))
        .thenReturn(java.util.Optional.of(personReturn));

    Person createdPerson = personService.getPersonById(1L);

    Mockito.verify(personRepository).findById(Mockito.any(Long.class));

    assertEquals(1L, createdPerson.getId());
    assertEquals(person.getUsername(), createdPerson.getUsername());
    assertEquals(person.getPassword(), createdPerson.getPassword());
    assertEquals(person.getRole(), createdPerson.getRole());
  }
}
