package com.example.a926975;

public class DecisionNode {

    int nodeID;
    int yesID;
    int noID;
    String description;
    String question;
    String choiceOne;
    String choiceTwo;
    DecisionNode choiceOneNode;
    DecisionNode choiceTwoNode;

    DecisionNode linkedNode;

    public DecisionNode() {}

    public DecisionNode getLinkedNode() { return linkedNode; }
    public void setLinkedNode(DecisionNode linkedNode) { this.linkedNode = linkedNode; }

    public int getNodeID() { return nodeID; }
    public void setNodeID(int nodeID) { this.nodeID = nodeID; }
    public int getYesID() { return yesID; }
    public void setYesID(int yesID) { this.yesID = yesID; }
    public int getNoID() { return noID; }
    public void setNoID(int noID) { this.noID = noID; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String getChoiceOne() { return choiceOne; }
    public void setChoiceOne(String choiceOne) { this.choiceOne = choiceOne; }
    public String getChoiceTwo() { return choiceTwo; }
    public void setChoiceTwo(String choiceTwo) { this.choiceTwo = choiceTwo; }
    public DecisionNode getChoiceOneNode() { return choiceOneNode; }
    public void setChoiceOneNode(DecisionNode choiceOneNode) { this.choiceOneNode = choiceOneNode; }
    public DecisionNode getChoiceTwoNode() { return choiceTwoNode; }
    public void setChoiceTwoNode(DecisionNode choiceTwoNode) { this.choiceTwoNode = choiceTwoNode; }
}
