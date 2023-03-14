package org.prog.web;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import javafx.beans.value.ObservableBooleanValue;
import org.junit.jupiter.api.Test;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;

import java.util.HashMap;

import static javafx.beans.binding.Bindings.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasItems;

public class RestTests {

  @Test
  public void myRestTest(){
  Response response = RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat");

    RootDto rootDto = response.body().as(RootDto.class);

    PersonDto person = rootDto.getResults().stream()
            .filter(p-> p.getGender().equals("male"))
                    .findFirst().get();

    String searchQuery = person.getName().getFirst() + "" + person.getName().getLast();

      System.out.println(rootDto.getInfo().getSeed());
      System.out.println(rootDto.getResults().get(0).getName().getFirst());
      System.out.println(rootDto.getResults().get(0).getName().getLast());

   }








    }


