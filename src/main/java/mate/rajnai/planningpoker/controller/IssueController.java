package mate.rajnai.planningpoker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/users/{userId}/issues")
public class IssueController {


    private final IssueService issueService;

    @GetMapping
    public String getIssuesOfUser(@PathVariable String userId, Model model) {
        List<Issue> issuesOfUser = this.issueService.getIssuesOfUser(userId);
        model.addAttribute("issuesOfUser", issuesOfUser);
        return "issues-of-user";
    }

    @GetMapping("/{issueId}/estimation")
    public String estimateIssue(@PathVariable String userId, @PathVariable String issueId, @RequestParam("value") String estimation, Model model) {
        this.issueService.estimateIssue(userId, issueId, estimation);
        log.info("Estimation: " + estimation);
        return "redirect:/api/users/".concat(userId).concat("/issues");
    }


}
