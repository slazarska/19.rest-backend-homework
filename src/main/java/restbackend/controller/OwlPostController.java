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
public class OwlPostController {

    private Map<String, StudentInfo> candidates = Map.of(
            "Harry Potter", StudentInfo.builder().studentName("Harry Potter").build(),
            "Draco Malfoy", StudentInfo.builder().studentName("Draco Malfoy").build(),
            "Hermione Granger", StudentInfo.builder().studentName("Hermione Granger").build());

    //получить всех кандидатов, у кого есть магические способности
    @GetMapping("candidate/getAllcandidates")
    @ApiOperation("Getting all candidates")
    public List<StudentInfo> getAllCandidatesInfo() {
        List<StudentInfo> result = new ArrayList<>();
        for (Map.Entry<String, StudentInfo> entry : candidates.entrySet()) {
            result.add(entry.getValue());
        }

        return candidates.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    //отправить письмо всем кандидатам со способностями
    @PostMapping("student/post")
    @ApiOperation("Sending Hogwarts Mail")
    public StudentInfo deliveryMail(@RequestBody PostInfo postInfo) {
        if (postInfo.getStudentName().equals("Harry Potter")) {
            return StudentInfo.builder()
                    .studentName(postInfo.getStudentName())
                    .build();
        } else {
            throw new InvalidNameException();
        }
    }
}
