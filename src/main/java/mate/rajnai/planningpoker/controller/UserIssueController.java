package mate.rajnai.planningpoker.controller;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/users/{userId}/issues")
public class UserIssueController {


    private final IssueService issueService;

    @GetMapping
    public String getIssueEstimationsOfUser(@PathVariable String userId, Model model) {
        List<IssueEstimation> issueEstimationsOfUser = this.issueService.getIssueEstimationsOfUser(userId);
        model.addAttribute("issueEstimationsOfUser", issueEstimationsOfUser);
        return "issues-of-user";
    }

    @GetMapping("/{issueId}/estimation")
    public String estimateIssue(@PathVariable String userId, @PathVariable String issueId, @RequestParam("value") String estimation, Model model) {
        this.issueService.estimateIssue(userId, issueId, estimation);
        return "redirect:/api/users/".concat(userId).concat("/issues");
    }


}
