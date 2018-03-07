package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.TreeSet;

import org.junit.Ignore;
import org.junit.Test;

public class Serving_08_TreeSetTest extends TestCase {
    @Ignore("Remove this line to run this test")
    @Test
    public void addReturnsSelf() {
        TreeSet<Integer> set = new TreeSet<>();
        assertEquals(set, set.add(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addIncreasesTheSize() {
        TreeSet<Integer> set = new TreeSet<>();
        assertEquals(0, set.size());
        set.add(42);
        assertEquals(1, set.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntIncreaseTheSizeIfTheValueIsAlreadyThere() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertEquals(1, set.size());
        set.add(42);
        assertEquals(1, set.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addTheFirstElementGoesToTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertEquals(42, Kamayan.getField(set, Integer.class, "root", "value"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntInsertADuplicateNode() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(42);
        assertNull(Kamayan.getField(set, Object.class, "root", "left"));
        assertNull(Kamayan.getField(set, Object.class, "root", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addASmallerObjectAddsToTheLeft() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        assertEquals(13, Kamayan.getField(set, Integer.class, "root", "left", "value"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addALargerObjectAddsToTheRight() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(84);
        assertEquals(84, Kamayan.getField(set, Integer.class, "root", "right", "value"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntInsertADuplicateNodeThatIsToTheLeftOfTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        set.add(13);
        assertNull(Kamayan.getField(set, Object.class, "root", "left", "left"));
        assertNull(Kamayan.getField(set, Object.class, "root", "left", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntInsertADuplicateNodeThatIsToTheRightOfTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(84);
        set.add(84);
        assertNull(Kamayan.getField(set, Object.class, "root", "right", "left"));
        assertNull(Kamayan.getField(set, Object.class, "root", "right", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsWithAnEmptyTreeReturnsFalse() {
        TreeSet<Integer> set = new TreeSet<>();
        assertFalse(set.contains(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsTrueWhereTheRootEqualsTheValue() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertTrue(set.contains(42));
        set.add(13);
        assertTrue(set.contains(42));
        set.add(84);
        assertTrue(set.contains(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsFalseWhereTheValueIsNotInTheTree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertFalse(set.contains(7));
        set.add(13);
        assertFalse(set.contains(7));
        set.add(84);
        assertFalse(set.contains(7));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsWhereTheValueIsOnTheLeftBranch() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        set.add(84);
        assertTrue(set.contains(13));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsWhereTheValueIsOnTheRightBranch() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        set.add(84);
        assertTrue(set.contains(84));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeDoesNothingWhenTheTreeIsEmpty() {
        TreeSet<Integer> set = new TreeSet<>();
        set.remove(42);
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeReturnsItself() {
        TreeSet<Integer> set = new TreeSet<>();
        assertEquals(set, set.remove(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeDecreasesTheSizeIfTheValueIsThere() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertEquals(1, set.size());
        set.remove(42);
        assertEquals(0, set.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeDoesntDecreaseTheSizeIfTheValueIsNotThere() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertEquals(1, set.size());
        set.remove(4);
        assertEquals(1, set.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeWithOneElementRemovesTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertNotNull(Kamayan.getField(set, Object.class, "root"));
        set.remove(42);
        assertNull(Kamayan.getField(set, Object.class, "root"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRootWhenThereIsOnlyALeftSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42).add(13).add(2).add(15);
        Object subtree = Kamayan.getField(set, Object.class, "root", "left");
        assertEquals(13, Kamayan.getField(subtree, Integer.class, "value"));
        set.remove(42);
        assertEquals(subtree, Kamayan.getField(set, Object.class, "root"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRootWhenThereIsOnlyARightSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-10).add(13).add(2).add(15);
        Object subtree = Kamayan.getField(set, Object.class, "root", "right");
        assertEquals(13, Kamayan.getField(subtree, Integer.class, "value"));
        set.remove(-10);
        assertEquals(subtree, Kamayan.getField(set, Object.class, "root"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRootWhenThereIsALeftAndRightSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42).add(13).add(2).add(15).add(84).add(68).add(100);
        Object leftSubtree = Kamayan.getField(set, Object.class, "root", "left");
        Object rightSubtree = Kamayan.getField(set, Object.class, "root", "right");
        Object graftingPoint = Kamayan.getField(leftSubtree, Object.class, "right");
        assertEquals(13, Kamayan.getField(leftSubtree, Integer.class, "value"));
        assertEquals(84, Kamayan.getField(rightSubtree, Integer.class, "value"));
        assertEquals(15, Kamayan.getField(graftingPoint, Integer.class, "value"));
        set.remove(42);
        assertEquals(leftSubtree, Kamayan.getField(set, Object.class, "root"));
        assertEquals(rightSubtree, Kamayan.getField(graftingPoint, Object.class, "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheLeftNodeWhenThereIsNoSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42).add(13);
        assertNotNull(Kamayan.getField(set, Object.class, "root", "left"));
        set.remove(13);
        assertNull(Kamayan.getField(set, Object.class, "root", "left"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheLeftNodeWhenThereIsOnlyALeftSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(150).add(42).add(13).add(2).add(15);
        Object subtree = Kamayan.getField(set, Object.class, "root", "left", "left");
        assertEquals(13, Kamayan.getField(subtree, Integer.class, "value"));
        set.remove(42);
        assertEquals(subtree, Kamayan.getField(set, Object.class, "root", "left"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheLeftNodeWhenThereIsOnlyARightSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(150).add(-10).add(13).add(2).add(15);
        Object subtree = Kamayan.getField(set, Object.class, "root", "left", "right");
        assertEquals(13, Kamayan.getField(subtree, Integer.class, "value"));
        set.remove(-10);
        assertEquals(subtree, Kamayan.getField(set, Object.class, "root", "left"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheLeftNodeWhenThereIsALeftAndRightSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(150).add(42).add(13).add(2).add(15).add(84).add(68).add(100);
        Object leftSubtree = Kamayan.getField(set, Object.class, "root", "left", "left");
        Object rightSubtree = Kamayan.getField(set, Object.class, "root", "left", "right");
        Object graftingPoint = Kamayan.getField(leftSubtree, Object.class, "right");
        assertEquals(13, Kamayan.getField(leftSubtree, Integer.class, "value"));
        assertEquals(84, Kamayan.getField(rightSubtree, Integer.class, "value"));
        assertEquals(15, Kamayan.getField(graftingPoint, Integer.class, "value"));
        set.remove(42);
        assertEquals(leftSubtree, Kamayan.getField(set, Object.class, "root", "left"));
        assertEquals(rightSubtree, Kamayan.getField(graftingPoint, Object.class, "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRightNodeWhenThereIsNoSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42).add(84);
        assertNotNull(Kamayan.getField(set, Object.class, "root", "right"));
        set.remove(84);
        assertNull(Kamayan.getField(set, Object.class, "root", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRightNodeWhenThereIsOnlyALeftSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-20).add(42).add(13).add(2).add(15);
        Object subtree = Kamayan.getField(set, Object.class, "root", "right", "left");
        assertEquals(13, Kamayan.getField(subtree, Integer.class, "value"));
        set.remove(42);
        assertEquals(subtree, Kamayan.getField(set, Object.class, "root", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRightNodeWhenThereIsOnlyARightSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-20).add(-10).add(13).add(2).add(15);
        Object subtree = Kamayan.getField(set, Object.class, "root", "right", "right");
        assertEquals(13, Kamayan.getField(subtree, Integer.class, "value"));
        set.remove(-10);
        assertEquals(subtree, Kamayan.getField(set, Object.class, "root", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void removeTheRightNodeWhenThereIsALeftAndRightSubtree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-20).add(42).add(13).add(2).add(15).add(84).add(68).add(100);
        Object leftSubtree = Kamayan.getField(set, Object.class, "root", "right", "left");
        Object rightSubtree = Kamayan.getField(set, Object.class, "root", "right", "right");
        Object graftingPoint = Kamayan.getField(leftSubtree, Object.class, "right");
        assertEquals(13, Kamayan.getField(leftSubtree, Integer.class, "value"));
        assertEquals(84, Kamayan.getField(rightSubtree, Integer.class, "value"));
        assertEquals(15, Kamayan.getField(graftingPoint, Integer.class, "value"));
        set.remove(42);
        assertEquals(leftSubtree, Kamayan.getField(set, Object.class, "root", "right"));
        assertEquals(rightSubtree, Kamayan.getField(graftingPoint, Object.class, "right"));
    }

    // Each returns itself
    // Each does nothing when the tree is empty
    // Each yields the root when there is just one node
    // Each yields all the elements when there are several nodes
    // Each yields from smallest to largest in a balanced tree
}
