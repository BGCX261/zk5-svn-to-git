/**
 * 
 */
package org.zkoss.selector.lang;

/**
 * 
 * @author simonpai
 */
public class Token {
	
	private int _begin;
	private int _end;
	private Type _type;
	
	public Token(Type group, int begin, int end){
		_type = group;
		_begin = begin;
		_end = end;
	}
	
	public Type getType(){
		return _type;
	}
	
	public int getBeginIndex(){
		return _begin;
	}
	
	public int getEndIndex(){
		return _end;
	}
	
	public static enum Type {
		// selector body //
		IDENTIFIER, UNIVERSAL,
		
		// white space, comma //
		WHITESPACE, COMMA,
		
		// combinator //
		CBN_CHILD, CBN_ADJACENT_SIBLING, CBN_GENERAL_SIBLING,
		
		// selector notation //
		NTN_ID, NTN_CLASS, NTN_PSDOCLS,
		
		// attribute boolean operator //
		OP_EQUAL, OP_BEGIN_WITH, OP_END_WITH, OP_CONTAIN,
		
		// pairwise //
		DOUBLE_QUOTE, OPEN_BRACKET, CLOSE_BRACKET, OPEN_PAREN, CLOSE_PAREN,
		
		// unknown //
		UNKNOWN_CHAR;
	}
	
	public String source(String mother){
		return mother.substring(_begin, _end);
	}
	
	@Override
	public String toString(){
		return _type + " [" + _begin + ", " + _end + "]";
	}
}
