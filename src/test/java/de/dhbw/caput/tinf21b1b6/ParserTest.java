package de.dhbw.caput.tinf21b1b6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class ParserTest {
	
	private static final FiniteStateAutomaton EVEN_PARITY = FiniteStateAutomaton.from(RegularExpression
			.from( "(0|1·0*·1)·(0|1·0*·1)*" ));
	private static final FiniteStateAutomaton NO_LEADING_ZEROS = FiniteStateAutomaton.from(RegularExpression
			.from( "0|(1|2|3|4|5|6|7|8|9)·(0|1|2|3|4|5|6|7|8|9)*" ));
	private static final FiniteStateAutomaton FLOATING_POINT = FiniteStateAutomaton.from(RegularExpression
			.from( "(ε|+|-)·(ε|((0|1|2|3|4|5|6|7|8|9)*·.))·(0|1|2|3|4|5|6|7|8|9)·(0|1|2|3|4|5|6|7|8|9)*" ));
	
	@ParameterizedTest
	@ValueSource( strings = {"0", "1", "12", "123"} )
	void accept_numbers_without_leading_zeros( String input ){
		assertTrue( NO_LEADING_ZEROS.accepts(input) );
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"", "00", "01", "012", "0049"} )
	void reject_numbers_with_leading_zeros( String input ){
		assertFalse( NO_LEADING_ZEROS.accepts(input) );
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"123", "+123", "123.456", ".456", "-.456"} )
	void accept_floating_point_numbers( String input ){
		assertTrue( FLOATING_POINT.accepts(input) );
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"", "123."} )
	void reject_non_floating_point_numbers( String input ){
		assertFalse( FLOATING_POINT.accepts(input) );
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"0", "00", "11", "000", "011", "101", "110"} )
	void accept_binaries_with_even_parity( String input ){
		assertTrue( EVEN_PARITY.accepts(input) );
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"", "1", "01", "10", "001", "010", "100", "111"} )
	void reject_binaries_with_odd_parity( String input ){
		assertFalse( EVEN_PARITY.accepts(input) );
	}
	
}
