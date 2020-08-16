package timberwolfgalaxy.coremod.capabilty;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import scala.actors.threadpool.Arrays;
import timberwolfgalaxy.coremod.objects.items.Wand;

public class KnownSpells implements IKnownSpells{
	
	private int[] knownSpells = {3};

	@Override
	public void learnAll() {
		for(int i = 0; i < Wand.SPELLS.size(); i++) {
			knownSpells = add(knownSpells, i);
		}
	}

	@Override
	public boolean learn(int spell) {
		if(contains(knownSpells, spell)) {
			return false;
		}else {
			knownSpells = add(knownSpells, spell);
			return true;
		}
	}

	@Override
	public boolean unlearn(int spell) {
		if(!contains(knownSpells, spell)) {
			return false;
		}else {
			knownSpells = ArrayUtils.remove(knownSpells, (indexOf(knownSpells, spell)));
			return true;
		}
	}

	@Override
	public int[] getKnownSpells() {
		int[] toReturn = new int[knownSpells.length];
		for(int i = 0; i < knownSpells.length; i++) {
			toReturn[i] = knownSpells[i];
		}
		return toReturn;
	}

	@Override
	public void setKnownSpells(int[] spells) {
		for(int i = 0; i < spells.length; i++) {
			knownSpells = ArrayUtils.add(knownSpells, spells[i]);
		}
	}
	
	private int[] add(int[] a, int i) {
		int[] b = new int[a.length + 1];
		for(int j = 0; j < a.length; j++) {
			b[j] = a[j];
		}
		b[a.length] = i;
		return b;
	}
	
	private int indexOf(int[] a, int element) {
		for(int i = 0; i < a.length; i++) {
			if (a[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean contains(int[] a, int element) {
		return indexOf(a, element) >= 0;
	}
}
