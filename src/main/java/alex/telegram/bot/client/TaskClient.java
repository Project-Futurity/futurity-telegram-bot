package alex.telegram.bot.client;

import alex.telegram.bot.model.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "task-client", url = "${telegram.task-service.url}")
public interface TaskClient {
    @GetMapping("/task/info/{id}")
    Task getTaskInfo(@PathVariable("id") Long taskId, @RequestHeader("user_id") Long userId);
}
