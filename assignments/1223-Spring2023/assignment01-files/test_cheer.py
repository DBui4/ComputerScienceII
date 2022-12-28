import unittest

from cheer import huskerMavScore
from cheer import winner

class CheerUnitTests(unittest.TestCase):

    list01 = [2, 9, 4, 25, 57, 45, 53]
    list02 = [5, 3, 45, 10, 1, 2, 0, 4]

    def test_score_001(self):
        expectedOutputA = 111
        expectedOutputB = 70
        (actualOutputA,actualOutputB) = huskerMavScore(self.list01)
        self.assertEqual(expectedOutputA, actualOutputA)
        self.assertEqual(expectedOutputB, actualOutputB)

    def test_winner_001(self):
        actualOutput = winner(self.list01)
        self.assertTrue( actualOutput < 0 )

    def test_score_002(self):
        expectedOutputA = 48
        expectedOutputB = 60
        (actualOutputA,actualOutputB) = huskerMavScore(self.list02)
        self.assertEqual(expectedOutputA, actualOutputA)
        self.assertEqual(expectedOutputB, actualOutputB)

    def test_winner_002(self):
        actualOutput = winner(self.list02)
        self.assertTrue( actualOutput > 0 )

    #TODO: additional test cases here

if __name__ == '__main__':
    #buffer=True suppresses stdout
    unittest.main(buffer=True)
