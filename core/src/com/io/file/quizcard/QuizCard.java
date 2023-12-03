package com.io.file.quizcard;

// chap14(2nd ed) or chap16(3d ed)
public class QuizCard {
  private final String question;
  private final String answer;

  public QuizCard(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}
