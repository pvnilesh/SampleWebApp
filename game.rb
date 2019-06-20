require 'set'

def rand_n(n,max)
  randoms = Set.new
  
  loop do
    if randoms.size >= n
      break
    end  
    randoms << rand(max)   
  end

  return randoms.to_a.join('')
end  

digits = 4

secret_number = rand_n(digits,10)
puts secret_number

max_guesses = 10
guess_count = 1
puts "a random #{digits} digits number(with unique digits) has been generated and saved into out.txt file(you can check it for validation)"
puts "You have total of #{max_guesses} guesses. Lets begin."

correct_guess = false

# create a loop asking for user input
loop do
	if guess_count > max_guesses
		break
	end
	
	# get the input from the user
	print "Guess #{guess_count}:"
	num = gets.chomp
	
	# validate the input
	arr = num.split('').uniq
	#p a
	if (num =~ /\A\d{4}\z/) && (arr.size == digits)
		# if guess is correct set the flag and break the loop
		if num == secret_number
			correct_guess = true
			break
		end
		
		p_count = 0
		d_count = 0
		x_count = 0
		# check for matching digits
		digits.times do |i|
			match_index = secret_number.index(arr[i])
			
			if match_index == i
				p_count += 1
			elsif match_index == nil
				x_count += 1
			else
				d_count += 1
			end
		end
		
		# print the matches
		puts "P->#{p_count}, D->#{d_count}, X->#{x_count}"
	else
		puts "Please enter a valid input"
		next
	end
	
	guess_count += 1
end

if correct_guess
	puts "you won!!! you took #{guess_count} guesses"
else
	puts "Game Over!!!"
end