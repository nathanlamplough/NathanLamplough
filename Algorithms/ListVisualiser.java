import java.awt.Graphics;
import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {
  static final long serialVersionUID = 10;
  int k = 0;
  int i = 0;

  public void paint(Graphics g) {
    if (ListVisualiser.arr == SLList.NIL) {
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString("/", (i * 40 + k + 15), 65);
      return;
    }
    for (i = 0; i < ListVisualiser.arl.size() - 1; i++) {
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString(ListVisualiser.arl.get(i).first.toString(), (i * 40 + k + 15), 65);
      k += 40;
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString("*", (i * 40 + k + 15), 65);
      k += 40;
      g.drawLine(i * 40 + k, 60, i * 40 + k + 40, 60);
    }
    if (ListVisualiser.floyd()) {
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString(ListVisualiser.arl.get(ListVisualiser.arl.size() - 1).first.toString(), (i * 40 + k + 15), 65);
      k += 40;
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString("*", (i * 40 + k + 15), 65);
      g.drawLine(i * 40 + k + 20, 80, i * 40 + k + 20, 120);
      g.drawLine(i * 40 + k + 20, 120, 20 + ListVisualiser.cycleIndex * 120, 120);
      g.drawLine(20 + ListVisualiser.cycleIndex * 120, 120, 20 + ListVisualiser.cycleIndex * 120, 80);
      k += 40;
    } else {
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString(ListVisualiser.arl.get(ListVisualiser.arl.size() - 1).first.toString(), (i * 40 + k + 15), 65);
      k += 40;
      g.drawRect(i * 40 + k, 40, 40, 40);
      g.drawString("/", (i * 40 + k + 15), 65);
    }
  }
}

public class ListVisualiser {
  public static List<SLList> arl = new ArrayList<SLList>();
  public static SLList arr;
  public static int cycleIndex;
  public static int cycleLength;

  public ListVisualiser(SLList l) {
    arr = l;
  }

  public static void window() {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(1600, 250);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }

  public static boolean floyd() {
    SLList tortoise = arr;
    SLList hare = arr.rest;
    cycleLength = 0;
    cycleIndex = 0;
    while (hare != SLList.NIL) {
      if (hare == tortoise) {
        tortoise = arr;
        hare = hare.rest;
        while (tortoise != hare) {
          cycleIndex++;
          tortoise = tortoise.rest;
          hare = hare.rest;
        }
        hare = hare.rest;
        cycleLength++;
        while (hare != tortoise) {
          cycleLength++;
          hare = hare.rest;
        }
        return true;
      }
      tortoise = tortoise.rest;
      if (hare.rest.rest == null) {
        break;
      }
      hare = hare.rest.rest;
    }
    return false;
  }

  public void visualise() {
    SLList a = arr;
    int k = 0;
    SLList loop = null;
    if (arr != SLList.NIL) {
      if (floyd()) {
        while (k < 10) {
          if (k == cycleIndex) {
            if (loop == arr) {
              break;
            }
            loop = a;
          }
          if (!arl.contains(a)) {
            arl.add(a);
          }
          a = a.rest;
          k++;
        }
      } else {
        while (a != SLList.NIL) {
          arl.add(a);
          a = a.rest;
        }
      }
    }
    window();
  }
}
