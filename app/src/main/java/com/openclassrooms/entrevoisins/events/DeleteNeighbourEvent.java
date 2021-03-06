package com.openclassrooms.entrevoisins.events;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */
public class DeleteNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public DeleteNeighbourEvent(Neighbour neighbour) {
        Log.i("DeleteNei", "DeleteNeighbourEvent: " + neighbour.toString());
        this.neighbour = neighbour;
    }

}
