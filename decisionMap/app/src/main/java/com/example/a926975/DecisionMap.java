package com.example.a926975;

import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Integer.*;

public class DecisionMap {
    DecisionNode head;
    DecisionNode tail;

    public DecisionMap(BufferedReader csvFile) throws IOException {
        buildUnorderedList(csvFile);
        buildOrderedMap();
        // unorderedMap = null;
    }

    private void append(DecisionNode newNode) {
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);

            return;
        }

        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }

    public void buildUnorderedList(BufferedReader dataSet) throws IOException {
        DecisionNode node;
        String row;

        while ((row = dataSet.readLine()) != null) {
            node = buildNode(row);
            append(node);
        }

        dataSet.close();
    }

    public void buildOrderedMap() {
        if (head == null) { return; }

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            int yesID = nodeLinker.getYesID();
            int noID = nodeLinker.getNoID();

            DecisionNode yesNode = nodeFetch(yesID);
            DecisionNode noNode = nodeFetch(noID);

            nodeLinker.setChoiceOneNode(yesNode);
            nodeLinker.setChoiceTwoNode(noNode);

            nodeLinker = nodeLinker.getLinkedNode();

        }
        cleanup();
    }

    private void cleanup(){
        if (head == null) { return; }

        DecisionNode currentNode = head;
        DecisionNode nextNode = head.getLinkedNode();

        while (nextNode != null) {
            currentNode.setLinkedNode(null);

            currentNode = nextNode;
            nextNode = currentNode.getLinkedNode();
        }
    }

    private DecisionNode buildNode(String line) {
        String[] stringArray = line.split(",");
        DecisionNode n = new DecisionNode();

        n.setNodeID(valueOf(stringArray[0]));
        n.setYesID(valueOf(stringArray[1]));
        n.setNoID(valueOf(stringArray[2]));

        n.setDescription(stringArray[3]);
        n.setQuestion(stringArray[4]);
        n.setChoiceOne(stringArray[5]);
        n.setChoiceTwo(stringArray[6]);

        return n;
    }

    public DecisionNode entryPoint() {
        return head;
    }

    private DecisionNode nodeFetch(int nodeID) {
        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            if(nodeLinker.getNodeID() == nodeID){ break ;}
            nodeLinker = nodeLinker.getLinkedNode();
        }

        return nodeLinker;
    }

    private boolean isEmpty() {
        return this.head == null;
    }
}