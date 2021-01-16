package mate.rajnai.planningpoker.controller;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/users/{userId}/issues")
public class IssueController {


    private final IssueService issueService;

    @GetMapping
    public String getIssuesOfUser(@PathVariable String userId, Model model) {
        return "issues-of-user";
    }



}
