package mate.rajnai.planningpoker.controller;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/issues")
public class AllIssueController {

    private final IssueService issueService;

    @GetMapping
    public String getAllIssues(Model model) {
        List<Issue> issues = this.issueService.getAllIssues();
        model.addAttribute("issues", issues);
        return "issues";
    }


}
