package com.projectalticci.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProjectController {

    private int alticci(int n) {

        if (n < 2)
            return n;
        else if (n == 2)
            return 1;
        else
            return alticci(n - 3) + alticci(n - 2);
    }

    @ApiOperation(value = "Alticci Sequence", notes = "This Endpoint Generates Alticci sequence")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Sequence Generated")
    })
    @GetMapping("/alticci/{n}")
    public ResponseEntity<List<Integer>> mapAlticci(@PathVariable(value = "n") int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++)
            result.add(alticci(i));

        return new ResponseEntity<List<Integer>>(result, HttpStatus.OK);
    }
}