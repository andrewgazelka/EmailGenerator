# EmailGenerator
When sending an email to a gmail account, Google is period-agnostic. This means that
`abcd@gmail.com = a.bcd@gmail.com = a.b.cd@gmail.com = a.b.c.d@gmail.com`. However, there can never be two periods at once. For example,
`ab..cd@gmail.com` is not a valid email. In addition, `@googlemail.com` redirects to `@gmail.com`. This script allows for generation of all possible
gmail addresses.
