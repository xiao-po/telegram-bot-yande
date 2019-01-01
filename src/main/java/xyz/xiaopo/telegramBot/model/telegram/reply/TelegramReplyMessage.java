package xyz.xiaopo.telegramBot.model.telegram.reply;

public class TelegramReplyMessage {
    Long chat_id;
    String text;
    String parse_mode;
    Boolean disable_web_page_preview;
    Boolean disable_notification;
    int reply_to_message_id;

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParse_mode() {
        return parse_mode;
    }

    public void setParse_mode(String parse_mode) {
        this.parse_mode = parse_mode;
    }

    public Boolean getDisable_web_page_preview() {
        return disable_web_page_preview;
    }

    public void setDisable_web_page_preview(Boolean disable_web_page_preview) {
        this.disable_web_page_preview = disable_web_page_preview;
    }

    public Boolean getDisable_notification() {
        return disable_notification;
    }

    public void setDisable_notification(Boolean disable_notification) {
        this.disable_notification = disable_notification;
    }

    public int getReply_to_message_id() {
        return reply_to_message_id;
    }

    public void setReply_to_message_id(int reply_to_message_id) {
        this.reply_to_message_id = reply_to_message_id;
    }

    public TelegramReplyMessage() {
        this.disable_notification = false;
        this.disable_web_page_preview = false;
        this.parse_mode = "";
    }
}
