/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

/**
 *
 * @author Holly
 */
public interface BodyComponent {
    public int getSize();
    public void add(BodyComponent component) throws LeafComponentException;
    public void remove(BodyComponent component) throws LeafComponentException;
    public BodyComponent getChild(int i) throws LeafComponentException;
}
