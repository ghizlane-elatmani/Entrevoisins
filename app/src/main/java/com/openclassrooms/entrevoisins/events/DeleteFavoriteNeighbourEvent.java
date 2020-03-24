package com.openclassrooms.entrevoisins.events;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */
public class DeleteFavoriteNeighbourEvent {

    /**
     * Favorite Neighbour to delete
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public DeleteFavoriteNeighbourEvent(Neighbour neighbour) {
        Log.i("DeleteNei", "DeleteNeighbourEvent: " + neighbour.toString());
        this.neighbour = neighbour;
    }

}
