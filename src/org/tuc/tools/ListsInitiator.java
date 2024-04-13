package org.tuc.tools;

import org.tuc.List;

/**
 * An interface utilized to create Lists
 */
public interface ListsInitiator {
    public int getNumOfLists();

    public List[] generateLists(int n);
}
