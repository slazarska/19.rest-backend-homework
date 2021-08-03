package restbackend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restbackend.domain.PostInfo;
import restbackend.domain.StudentInfo;
import restbackend.exception.InvalidNameException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SortingHutController {

    //распределить
//    @PostMapping("candidate/delivery")
//    @ApiOperation("Sending Hogwarts Mail")
//    public StudentInfo deliveryMail(@RequestBody PostInfo candidateInfo) {
//        if (PostInfo.getCandidateInfoName().equals("Harry Potter")) {
//            return StudentInfo.builder()
//                    .postDeliveryDate(new Date())
//                    .candidateName(candidateInfo.getCandidateInfoName())
//                    .build();
//        } else {
//            throw new InvalidNameException();
//        }
//    }

    //получаем списки факультетов
//    @GetMapping("student/house")
//    @ApiOperation("Getting all students from house")
//    public List<StudentInfo> getAllStudentInfo() {
//        List<StudentInfo> result = new ArrayList<>();
//        for (Map.Entry<String, StudentInfo> entry : students.entrySet()) {
//            result.add(entry.getValue());
//        }
//
//        return students.entrySet()
//                .stream()
//                .map(Map.Entry::getValue)
//                .collect(Collectors.toList());
//    }
}
