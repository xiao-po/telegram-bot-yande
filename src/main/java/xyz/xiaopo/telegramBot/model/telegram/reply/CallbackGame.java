package xyz.xiaopo.telegramBot.model.telegram.reply;

public class CallbackGame {
    int user_id;
    int score;
    boolean force;
    boolean disable_edit_message;
    Long chat_id;
    String inline_message_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public boolean isDisable_edit_message() {
        return disable_edit_message;
    }

    public void setDisable_edit_message(boolean disable_edit_message) {
        this.disable_edit_message = disable_edit_message;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getInline_message_id() {
        return inline_message_id;
    }

    public void setInline_message_id(String inline_message_id) {
        this.inline_message_id = inline_message_id;
    }

    public CallbackGame() {
    }
}
