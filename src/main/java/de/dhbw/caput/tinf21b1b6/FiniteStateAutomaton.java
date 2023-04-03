package de.dhbw.caput.tinf21b1b6;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

final class FiniteStateAutomaton implements Serializable {
	
	private static final long serialVersionUID = 3495083507867329266L;
	
	public final State INITIAL_STATE;
	public final State ACCEPTING_STATE;
	
	FiniteStateAutomaton( ){
		super( );
		INITIAL_STATE = new State( );
		ACCEPTING_STATE = new State( );
	}
	
	static FiniteStateAutomaton from( RegularExpression regularExpression ){
		return regularExpression.generateFSA();
	}
	
	boolean accepts( String string ){
		Controller controller = instantiate( );
		for( int i = 0; i < string.length(); ++i ){
			controller.process( string.charAt(i) );
		}
		return controller.state().contains( ACCEPTING_STATE );
	}
	
	Controller instantiate( ){
		return new Controller( );
	}
	
	
	
	final class Controller {
		
		private Set<State> states;
		
		private Controller( ){
			super( );
			states = INITIAL_STATE.resolveEpsilonTransitions( );
		}
		
		private Set<State> state( ){
			return states;
		}
		
		void process( char symbol ){
			Set<State> nextStates = new HashSet<>( );
			for( State state : states ){
				nextStates.addAll( state.reactOn(symbol) );
			}
			Queue<State> queue = new LinkedList<>( );
			queue.addAll( nextStates );
			nextStates = State.resolveEpsilonTransitions( queue );
			states = nextStates;
		}
		
		boolean isActive( ){
			return !states.isEmpty();
		}
		
		boolean acceptsInput( ){
			return states.contains( ACCEPTING_STATE );
		}
		
		FiniteStateAutomaton definition( ){
			return FiniteStateAutomaton.this;
		}
		
	}
	
}
