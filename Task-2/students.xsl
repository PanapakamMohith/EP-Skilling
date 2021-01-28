<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/Students">

		<html>
			<body>
				<h1 align="center">Student Table</h1>
				<table bgcolor = "LightGray" border = "1" align = "center">
					<tr><th>Student name</th><th>Student email</th><th>Class</th><th>Marks</th></tr>
					<xsl:for-each select = "student">
					<tr>
					<td bgcolor = "violet"><xsl:value-of select= "name"/></td>
					<td bgcolor = "DodgerBlue"><xsl:value-of select= "email"/></td>
					<td bgcolor = "MediumSeaGreen"><xsl:value-of select= "class"/></td>
					<td bgcolor = "Tomato"><xsl:value-of select= "marks"/></td>
					</tr>
					</xsl:for-each>
				</table>

			</body>

		</html>
	</xsl:template>
</xsl:stylesheet>