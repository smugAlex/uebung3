package org.example;

import java.util.Arrays;

/**
 * Programm, welches einen einfachen Stack implementiert
 */
public class OurStack {
  int currentSize = 0;
  String[] stack;

  public static void main(String[] args) {

    OurStack s = new OurStack();
    String operation;

    do {
      operation = SimpleIO.getString(
        "Bitte geben Sie eine Operation (PUSH,POP,CLEAR,SETSIZE,PRINT,STOP) ein:");
      switch(operation) {
        case "PUSH" -> s.push(SimpleIO.getString(""));
        case "POP" -> s.pop();
        case "CLEAR" -> s.clear();
        case "SETSIZE" -> {
          int size = 0;
          do
            size = SimpleIO.getInt(
              "Bitte geben Sie die (nicht negative) Groesse ein:");
          while(size <  0);
          s.setSize(size);
        }
        case "PRINT", "STOP" -> s.print();
        default -> SimpleIO.output("Fehlerhafte Eingabe!");
      }
    } while(!operation.equals("STOP"));
  }

  public String push(String string) {
    if (stack == null) {
      SimpleIO.output("Stack is not initialized. Use SETSIZE to define stack size.");
      return "Stack not initialized";
    }
    if (currentSize < stack.length) {
      stack[currentSize] = string;
      currentSize++;
      return string;
    } else {
      SimpleIO.output("Stack ist voll.");
      return "Stack is full";
    }
  }

  public void pop() {
    // TODO
    if(stack.length>1){
      stack[currentSize-1] = null;
      currentSize-=1;
    }else SimpleIO.output("Es gibt nicht genug Elemente in dem Stack!");
  }

  public void clear() {
    for (int i = 0; i < currentSize; i++) {
      stack[i] = null;
    }
    currentSize = 0;
  }

  public void setSize(int size) {
    stack = new String[size];
    currentSize = Math.min(currentSize, size);
  }

  public void print() {
    String line = "Stack: ";
    for (int i = 0; i < currentSize; i++) {
      line += stack[i]+" ";
    }
    SimpleIO.output(line);
  }
}
