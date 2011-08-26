/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.core;


//import java.util.Collection;
import java.util.HashSet;

/**
* The SBOL data model's Collection for RDF and Json.
 *
 * The objects of this type represent an organizational container which helps
 * users and developers conceptualize a set of DNA components and SequenceFeatures
 * as a group. Any combination of these objects can be added to a Collection,
 * annotated with a displayID, name and description and be shared on the web.
 * Such collections could be a set of restriction enzyme recognition
 * sites, such as the features commonly used for BBF RFC 10 BioBricks. A Collection
 * could contain all the DNA components used in a specific project, lab, or any
 * custom grouping specified by the user.
 *
 * COMMENT: Mike Galdzicki thinks Collection is a Generic metadata object. This metadata
 * element, is a set. It would be best defined by queries, when there is information
 * that groups the collection. Arbitrary groupings and new Collection objects should
 * not be created and named when the groupings are not defined, but also Libraries
 * should not be created whenever an arbitrary set is possible, only create if useful.
 * Extensions for useful computable objects should be proposed to help Collection
 * definitions.
 *
 * @author mgaldzic
 * @since  0.6.0, 08/26/2011
 */

public class Collection {
   
    private String displayId;
    private String name;
    private String description;
    private java.util.Collection<DnaComponent> component = new HashSet<DnaComponent>();

    /**
     * Elements that are intended as engineering components in synthetic biology.
     *
     * For example, standard biological parts, BioBricks, oligo components,
     * vector plasmids, genomes, or any other DNA segment of interest as a building
     * block of biological systems.
     *
     * @return 0 or more <code>DnaComponent</code>[s] that are in this Collection
     */
    public java.util.Collection<DnaComponent> getComponents() {
        return component;
    }
    /**
     * Defined DNA segment for engineering biological systems, which belongs to
     * this Collection.
     *
     * Any one of the following, standard biological parts, BioBricks, oligo components,
     * vector plasmids, genomes, or any other DNA segment of interest as a building
     * block of biological systems.
     *
     * @param component a <code>DnaComponent</code> that should be a member of this collection
     */
    public void addComponent(DnaComponent component) {
        if (!getComponents().contains(component)) {
            getComponents().add(component);
        }
    }

    /**
     * Text which is for users to read and interpret what this Collection is.
     * (eg "Collecting parts which could be used to build honey production directly into
     * mouse-ear cress"; "T9002 and I7101 variants from Sleight 2010, designs aim to
     * improve stability over evolutionary time"; "features useful when working with
     * BBF RFC 10"; "Totally sick Parts I found browsing the web -- SBOL rules
     * -- organize these later").
     *
     * Informative description which allows human users to interpret the likely
     * members of this Collection.
     * @return Human readable text describing the Collection
     */
    public String getDescription() {
        return description;
    }

    /**
     * Text with an informative statement about the reason for grouping the Collection members.
     * (eg "Collecting parts which could be used to build honey production directly into
     * mouse-ear cress"; "T9002 and I7101 variants from Sleight 2010, designs aim to
     * improve stability over evolutionary time"; "features useful when working with
     * BBF RFC 10"; "Totally sick Parts I found browsing the web -- SBOL rules
     * -- organize these later").
     *
     * @param description Human readable text describing the Collection
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Identifier to display to users.
     * @return a human readable identifier
     */
    public String getDisplayId() {
        return displayId;
    }

    /**
     * Identifier to display to users.
     * @param displayId a human readable identifier
     */
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    /**
     * Recognizable human identifier, it is often ambiguous.(eg. Mike's Arabidopsis Project A;
     * Sleight, et al. (2010) J.Bioeng; BBF RFC 10 features; Bookmarked Parts).
     * @return its name, commonly used to refer to this Collection
     */
    public String getName() {
        return name;
    }

    /**
     * Common name of Collection should confer what is contained in the Collection.
     *(eg. Mike's Arabidopsis Project A;
     * Sleight, et al. (2010) J.Bioeng; BBF RFC 10 features; Bookmarked Parts).
     * @param name commonly used to refer to this Collection (eg. Project A)
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Collection other = (Collection) obj;
      
            if ((this.displayId == null) ? (other.displayId != null) : !this.displayId.equals(other.displayId)) {
                return false;
            }
            if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
                return false;
            }
            if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
                return false;
            }
            if (this.component != other.component && (this.component == null || !this.component.equals(other.component))) {
                return false;
            }
        return true;
    }

    @Override
    public int hashCode() {
       // return getRdfId() == null ? 0 : getRdfId().value().hashCode();
        return 0;
    }
}
