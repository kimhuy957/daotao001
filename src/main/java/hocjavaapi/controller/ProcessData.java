package hocjavaapi.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ProcessData {

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/processdata", method = RequestMethod.GET)
    public ResponseEntity<String> processData(@RequestBody String request) {
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall("{call trungapiservice.trunginsert(?)}")) {
            stmt.setString(1, request);
            stmt.execute();
            return new ResponseEntity<>("Hoan thanh aaaas111", HttpStatus.OK);
            //return ResponseEntity.ok("Data processed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            // return new ResponseEntity<>("Loi thuc hien", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

