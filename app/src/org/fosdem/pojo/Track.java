package org.fosdem.pojo;
/**
 *  This file is part of the FOSDEM Android application.
 *  http://android.fosdem.org
 *  
 *  Thisis open source software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  It is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this software.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  @author Christophe Vandeplas <christophe@vandeplas.com>
 */


import java.util.ArrayList;
import java.util.Collection;

public class Track {

	private String name;
	private ArrayList<Event> events = new ArrayList<Event>();
	
	public Track(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	public void addEvents(Collection<Event> events){
		this.events.addAll(events);
	}
	

	public String getType() {
		// RMLL 2012 specific parts
        String[] mainTracks = { "Cultures et Arts Libres", "Communautés",
                "Politique, droit et administrations publiques",
                "Média, radio, télévision et graphisme professionnel",
                "Entreprises et Logiciel Libre", };
        String[] scienceTrack = { "Enseignement de l'école à l'Université",
                "Recherche et université", };
        String[] healthTrack = {
                "Imagerie et visualisation de données médicales",
                "Accessibilité, autonomie et gestion de la dépendance",
                "Système d'informations hospitalier et télésanté", };
        String[] techTrack = { "Administration Système",
                "Développement logiciel",
                "Systèmes Embarqués et Matériel Libre",
                "Systèmes d'Exploitation", "Sécurité", "Internet" };
        String[] sameAsTrack = { "Général", "Divers" };
		
		// Main Tracks
		for (String s: mainTracks) {
			if (0==name.compareTo(s)) return "Main Track";
	    }
        // 
        for (String s: sameAsTrack) {
            if (0==name.compareTo(s)) return name;
        }
        // 
        for (String s: scienceTrack) {
            if (0==name.compareTo(s)) return "Sciences et formation";
        }
        // 
        for (String s: healthTrack) {
            if (0==name.compareTo(s)) return "Santé et Accessibilité";
        }
        // 
        for (String s: techTrack) {
            if (0==name.compareTo(s)) return "Technique";
        }
		// Rest are unknown
		return "Unknown";
	}
}
