/*	Programmer:		Jack Donato
	Alterations:	Marcus Ross	*/

package lab03;

import lab03.*;

public class List {
	private Element[] data;
	private int size;
	private int index;

	public List() {	}

	public List(int size) {
		create(size);
	}

	public void create(int size) {
		data = new Element[size];
		this.size = 0;
		index = 0;
	}

	public void destroy() {
		for(Element elemCur:data)
			elemCur = null;
		size = -1;
		index = -1;
	}

	public boolean isFull() {
		boolean result;
		result = size == data.length;
		return result;
	}

	public boolean search(String searchStr) {
		boolean result = false;
		reset();
		while(!atEnd() && !searchStr.equals(data[index].getKey()))
			getNext();
		if(!atEnd())
			result = true;
		else
			result = false;
		return result;
	}

	public boolean delete(String searchStr) {
		boolean result;
		result = search(searchStr);
		if(result) {
			while(index < size)
				data[index] = data[++index];
			size--;
		}
		return result;
	}

	public boolean add(Element element) {
		boolean result;
		if(isFull())
			result = false;
		else {
			result = true;
			data[size++] = element.clone();
		}
		return result;
	}

	public Element retrieve() {
		Element element;
		if(isEmpty() || atEnd())
			return null;
		element = data[index].clone();
		return element;
	}

	public void reset() {
		index = 0;
	}

	public boolean getNext() {
		boolean result;
		if(atEnd() || isEmpty())
			result = false;
		else {
			result = true;
			index++;
		}
		return result;
	}

	public boolean atEnd() {
		boolean result;
		if(index == size)
			result = true;
		else
			result = false;
		return result;
	}

	public boolean isEmpty() {
		boolean result;
		if(size == 0)
			result = true;
		else
			result = false;
		return result;
	}
}
