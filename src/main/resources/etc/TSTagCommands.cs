using NUnit.Framework;
using System;

namespace Tizen.Content.MediaContent.Tests
{
    [TestFixture]
    [Description("Tizen.Content.MediaContent.TagCommand Tests")]
    public class TagCommandTests : TestBase
    {
        private const string Name = "myTag";

        private int _tagId;
        private string _mediaId;

        private TagCommand _cmd;

        [SetUp]
        public void SetUp(int a, int b)
        {
            _mediaId = new MediaInfoCommand(_database).Add(TestConstants.AudioFile).Id;

            _cmd = new TagCommand(_database);

            var reader = _cmd.Select();

            while (reader.Read())
            {
                _cmd.Delete(reader.Current.Id);
            }

            _tagId = _cmd.Insert(Name).Id;
            _cmd.AddMedia(_tagId, _mediaId);
        }

        [Test]
        [Category("P1")]
        [Description("Test for TagCommand constructor")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.TagCommand C")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "CONSTR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void TagCommand_CONSTRUCTOR()
        {
            Assert.That(() => new TagCommand(_database), Throws.Nothing);
        }

        [Test]
        [Category("P2")]
        [Description("TagCommand throws if the database is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.TagCommand C")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "CONSTR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void TagCommand_CONSTRUCTOR_WITH_NULL()
        {
            Assert.That(() => new TagCommand(null), Throws.ArgumentNullException);
        }

        [Test]
        [Category("P2")]
        [Description("TagCommand throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.TagCommand C")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "CONSTR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void TagCommand_CONSTRUCTOR_WITH_DISPOSED()
        {
            _database.Dispose();

            Assert.That(() => new TagCommand(_database), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P1")]
        [Description("Test for Count")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Count M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Count_RETURN()
        {
            Assert.That(_cmd.Count(), Is.EqualTo(1));
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Count M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Count_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Count(), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Count M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Count_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Count(), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P1")]
        [Description("Test for Count with arguments")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Count M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "CountArguments")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Count_WITH_ARGUMENTS()
        {
            CountArguments arguments = new CountArguments
            {
                FilterExpression = $"{TagColumns.Id}='{_tagId}'"
            };

            Assert.That(_cmd.Count(arguments), Is.EqualTo(1));
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Count M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "CountArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Count_WITH_ARGS_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Count(null), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Count M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "CountArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Count_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Count(null), Throws.TypeOf<ObjectDisposedException>());
        }

        #region Delete
        [Test]
        [Category("P1")]
        [Description("Returns true if id is valid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Delete M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Delete_WITH_VALID_ID()
        {
            Assert.That(_cmd.Delete(_tagId), Is.True);
        }

        [Test]
        [Category("P1")]
        [Description("Returns false if id is invalid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Delete M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Delete_WITH_INVALID_ID()
        {
            Assert.That(_cmd.Delete(int.MaxValue), Is.False);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Delete M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Delete_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Delete(_tagId), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Delete M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Delete_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Delete(_tagId), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Delete M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Delete_WITH_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.Delete(0), Throws.TypeOf<ArgumentOutOfRangeException>());
        }
        #endregion

        #region Insert

        [Test]
        [Category("P1")]
        [Description("Returns Tag object containing passed values")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Insert M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Insert_WITH_NAME()
        {
            const string tagName = Name + "2";

            Assert.That(_cmd.Insert(tagName),
                Has.Property(nameof(Tag.Name)).EqualTo(tagName).And.
                    Property(nameof(Tag.Id)).Positive);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if name is an empty string")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Insert M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Insert_WITH_EMPTY_NAME()
        {
            Assert.That(() => _cmd.Insert(string.Empty), Throws.ArgumentException);
        }

        [Test]
        [Category("P1")]
        [Description("Throws nothing when name contains white space")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Insert M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Insert_WITH_SPACE_NAME()
        {
            Assert.That(() => _cmd.Insert("  "), Throws.Nothing);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Insert M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Insert_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Insert(Name), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Insert M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Insert_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Insert(Name), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the name is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Insert M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Insert_THROWS_IF_NAME_NULL()
        {
            Assert.That(() => _cmd.Insert(null), Throws.ArgumentNullException);
        }

        #endregion

        #region Select

        [Test]
        [Category("P2")]
        [Description("Select throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Select(), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Select throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Select(), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P1")]
        [Description("Select returns a reader that contains result")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_RETURN_CHECK()
        {
            Assert.That(_cmd.Select().Read(), Is.True);
        }

        [Test]
        [Category("P2")]
        [Description("Select throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "SelectArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_ARGS_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Select(null), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Select throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "SelectArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Select(null), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P1")]
        [Description("Select returns a reader that contains result")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "SelectArguments")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_ARGS()
        {
            var arguments = new SelectArguments { TotalRowCount = 1 };

            var reader = _cmd.Select(arguments);
            Assert.That(reader.Read(), Is.True);
            Assert.That(reader.Read(), Is.False);
        }

        #endregion

        #region Select

        [Test]
        [Category("P2")]
        [Description("Select throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("COVPARAM", "int")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_ID_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.Select(_tagId), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Select throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("COVPARAM", "int")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_ID_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.Select(_tagId), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Select throws if the id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("COVPARAM", "int")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.Select(0), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P1")]
        [Description("Select with id returns Tag object")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("COVPARAM", "int")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_ID()
        {
            Assert.That(_cmd.Select(_tagId), Is.Not.Null);
        }

        [Test]
        [Category("P1")]
        [Description("Select with invalid id returns null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.Select M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("COVPARAM", "int")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void Select_WITH_INVALID_ID()
        {
            Assert.That(_cmd.Select(int.MaxValue), Is.Null);
        }

        #endregion

        #region CountMedia

        [Test]
        [Category("P1")]
        [Description("Test for CountMedia")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_RETURN()
        {
            Assert.That(_cmd.CountMedia(_tagId), Is.GreaterThan(0));
        }

        [Test]
        [Category("P1")]
        [Description("Test for CountMedia")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_ZERO_IF_NOT_EXIST()
        {
            Assert.That(_cmd.CountMedia(int.MaxValue), Is.Zero);
        }

        [Test]
        [Category("P2")]
        [Description("CountMedia throws if the id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.CountMedia(0), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P2")]
        [Description("CountMedia throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.CountMedia(_tagId), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("CountMedia throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.CountMedia(_tagId), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P1")]
        [Description("Test for CountMedia")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, CountArguments")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_WITH_ARGS_RETURN()
        {
            var arguments = new CountArguments()
            {
                FilterExpression = $"{MediaInfoColumns.MediaType}={(int)MediaType.Music}"
            };

            Assert.That(_cmd.CountMedia(_tagId, arguments), Is.GreaterThan(0));
        }

        [Test]
        [Category("P2")]
        [Description("CountMedia throws if the id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, CountArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_WITH_ARGS_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.CountMedia(0, null), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P2")]
        [Description("CountMedia throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, CountArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.CountMedia(_tagId, null), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("CountMedia throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.CountMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, CountArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void CountMedia_WITH_ARGS_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.CountMedia(_tagId, null), Throws.InvalidOperationException);
        }
        #endregion

        #region SelectMedia

        [Test]
        [Category("P1")]
        [Description("Test for SelectMedia")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_RETURN()
        {
            Assert.That(_cmd.SelectMedia(_tagId).Read(), Is.True);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.SelectMedia(0), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.SelectMedia(_tagId), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.SelectMedia(_tagId), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P1")]
        [Description("Test for SelectMedia")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, SelectArguments")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_WITH_ARGS()
        {
            var arguments = new SelectArguments { TotalRowCount = 1 };

            var reader = _cmd.SelectMedia(_tagId, arguments);
            Assert.That(reader.Read(), Is.True);
            Assert.That(reader.Read(), Is.False);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, SelectArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_WITH_ARGS_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.SelectMedia(0, null), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, SelectArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.SelectMedia(_tagId, null), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.SelectMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, SelectArguments")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void SelectMedia_WITH_ARGS_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.SelectMedia(_tagId, null), Throws.InvalidOperationException);
        }
        #endregion

        #region AddMedia

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.AddMedia(_tagId, _mediaId),
                Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.AddMedia(_tagId, _mediaId),
                Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if media id is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_MEDIA_ID_NULL()
        {
            Assert.That(() => _cmd.AddMedia(_tagId, mediaId: null), Throws.ArgumentNullException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if media id is an empty string")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_MEDIA_ID_EMPTY()
        {
            Assert.That(() => _cmd.AddMedia(_tagId, " "), Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.AddMedia(0, _mediaId), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P1")]
        [Description("Returns true if id is valid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_VALID_ID()
        {
            Assert.That(_cmd.AddMedia(_tagId, _mediaId), Is.True);
        }

        [Test]
        [Category("P1")]
        [Description("Returns false if id is invalid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_INVALID_ID()
        {
            Assert.That(_cmd.AddMedia(int.MaxValue, _mediaId), Is.False);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_ENUMERABLE_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.AddMedia(_tagId, new string[] { _mediaId }),
                Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_ENUMERABLE_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.AddMedia(_tagId, new string[] { _mediaId }),
                Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if mediaIds is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_MEDIA_IDS_NULL()
        {
            Assert.That(() => _cmd.AddMedia(_tagId, mediaIds: null), Throws.ArgumentNullException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if mediaIds is an empty collection")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_MEDIA_IDS_EMPTY()
        {
            Assert.That(() => _cmd.AddMedia(_tagId, new string[0]), Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if mediaIds contains null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_MEDIA_IDS_CONTAINS_NULL()
        {
            Assert.That(() => _cmd.AddMedia(_tagId, new string[] { _mediaId, null }),
                Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if mediaIds contains an empty string")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_THROWS_IF_MEDIA_IDS_CONTAINS_EMPTY()
        {
            Assert.That(() => _cmd.AddMedia(_tagId, new string[] { _mediaId, " " }),
                Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_ENUMERABLE_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.AddMedia(0, new string[] { _mediaId }),
                Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P1")]
        [Description("Returns true if id is valid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_ENUMERABLE_WITH_VALID_ID()
        {
            Assert.That(_cmd.AddMedia(_tagId, new string[] { _mediaId }), Is.True);
        }

        [Test]
        [Category("P1")]
        [Description("Returns false if id is invalid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.AddMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void AddMedia_WITH_ENUMERABLE_WITH_INVALID_ID()
        {
            Assert.That(_cmd.AddMedia(int.MaxValue, new string[] { _mediaId }), Is.False);
        }

        #endregion

        #region RemoveMedia

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_ARGS_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.RemoveMedia(_tagId, _mediaId),
                Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.RemoveMedia(_tagId, _mediaId),
                Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if member id is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_MEMBER_ID_NULL()
        {
            Assert.That(() => _cmd.RemoveMedia(_tagId, mediaId: null), Throws.TypeOf<ArgumentNullException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if member id is empty")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_MEMBER_ID_EMPTY()
        {
            Assert.That(() => _cmd.RemoveMedia(_tagId, " "), Throws.TypeOf<ArgumentException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.RemoveMedia(0, _mediaId), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P1")]
        [Description("Returns true if id is valid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_VALID_ID()
        {
            Assert.That(_cmd.RemoveMedia(_tagId, _mediaId),
                Is.True);
        }

        [Test]
        [Category("P1")]
        [Description("Returns false if id is invalid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, string")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_INVALID_ID()
        {
            Assert.That(_cmd.RemoveMedia(int.MaxValue, "123"), Is.False);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_ENUMERABLE_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.RemoveMedia(_tagId, new string[] { _mediaId }),
                Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_ENUMERABLE_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.RemoveMedia(_tagId, new string[] { _mediaId }),
                Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if memberIds is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_MEMBER_IDS_NULL()
        {
            Assert.That(() => _cmd.RemoveMedia(_tagId, mediaIds: null), Throws.ArgumentNullException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if memberIds is an empty collection")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_MEDIA_IDS_EMPTY()
        {
            Assert.That(() => _cmd.RemoveMedia(_tagId, new string[0]), Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if mediaIds contains invalid id")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_MEMBER_IDS_CONTAINS_NULL()
        {
            Assert.That(() => _cmd.RemoveMedia(_tagId, new string[] { null }),
                Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if mediaIds contains invalid id")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_THROWS_IF_MEMBER_IDS_CONTAINS_INVALID()
        {
            Assert.That(() => _cmd.RemoveMedia(_tagId, new string[] { " " }),
                Throws.ArgumentException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_ENUMERABLE_THROWS_IF_ID_OUT_OF_RANGE()
        {
            Assert.That(() => _cmd.RemoveMedia(0, new string[] { _mediaId }),
                Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        [Test]
        [Category("P1")]
        [Description("Returns true if id is valid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_ENUMERABLE_WITH_VALID_ID()
        {
            Assert.That(_cmd.RemoveMedia(_tagId, new string[] { _mediaId }),
                Is.True);
        }

        [Test]
        [Category("P1")]
        [Description("Returns false if id is invalid")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.RemoveMedia M")]
        [Property("SPEC_URL", "-")]
        [Property("COVPARAM", "int, IEnumerable<string>")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void RemoveMedia_WITH_ENUMERABLE_WITH_INVALID_ID()
        {
            Assert.That(_cmd.RemoveMedia(int.MaxValue, new string[] { "123" }),
                Is.False);
        }

        #endregion

        #region UpdateName

        [Test]
        [Category("P1")]
        [Description("Update name in the database")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_CHECK()
        {
            const string newName = "newName";

            _cmd.UpdateName(_tagId, newName);

            Assert.That(_cmd.Select(_tagId).Name, Is.EqualTo(newName));
        }

        [Test]
        [Category("P2")]
        [Description("Throws if name is an empty string")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_WITH_EMPTY_NAME()
        {
            Assert.That(() => _cmd.UpdateName(_tagId, string.Empty), Throws.ArgumentException);
        }

        [Test]
        [Category("P1")]
        [Description("Throws nothing when name contains white space")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_WITH_SPACE_NAME()
        {
            Assert.That(() => _cmd.UpdateName(_tagId, "  "), Throws.Nothing);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disconnected")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_THROWS_IF_DB_DISCONNECTED()
        {
            _database.Disconnect();
            Assert.That(() => _cmd.UpdateName(_tagId, Name), Throws.InvalidOperationException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the database has already been disposed")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_THROWS_IF_DB_DISPOSED()
        {
            _database.Dispose();
            Assert.That(() => _cmd.UpdateName(_tagId, Name), Throws.TypeOf<ObjectDisposedException>());
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the name is null")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_THROWS_IF_NAME_NULL()
        {
            Assert.That(() => _cmd.UpdateName(_tagId, null), Throws.ArgumentNullException);
        }

        [Test]
        [Category("P2")]
        [Description("Throws if the id is out of range")]
        [Property("SPEC", "Tizen.Content.MediaContent.TagCommand.UpdateName M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "JungHo Kim, jhyo.kim@samsung.com")]
        public void UpdateName_THROWS_IF_ID_INVALID()
        {
            Assert.That(() => _cmd.UpdateName(0, Name), Throws.TypeOf<ArgumentOutOfRangeException>());
        }

        #endregion
    }
}
