package marcoantn020.chat.controller;

import marcoantn020.chat.controller.dto.ChatInputDto;
import marcoantn020.chat.controller.dto.ChatOutputDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutputDto newMessage(ChatInputDto dto) {
        return new ChatOutputDto(HtmlUtils.htmlEscape(dto.user() +": "+ dto.message()));
    }
}
