/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2014 (12.0.2269)
    Source Database Engine Edition : Microsoft SQL Server Enterprise Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [MY_DB]
GO
/****** Object:  Table [dbo].[data_tb_01]    Script Date: 20/02/2019 11:21:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[data_tb_01](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[field_one] [varchar](100) NULL,
	[field_two] [varchar](255) NULL,
 CONSTRAINT [PK_data_tb_01] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[data_tb_02]    Script Date: 20/02/2019 11:21:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[data_tb_02](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[field_three] [varchar](50) NULL,
	[field_four] [varchar](100) NULL,
	[id_tb_01] [int] NULL,
 CONSTRAINT [PK_data_tb_02] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[uv_my_view]    Script Date: 20/02/2019 11:21:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO













CREATE VIEW [dbo].[uv_my_view]
AS
	SELECT D1.id,D1.field_one,D1.field_two,COUNT(D2.id) as count_children FROM data_tb_01 as D1 inner join data_tb_02 as D2 on D1.id=D2.id_tb_01
	GROUP BY D1.id,D1.field_one,D1.field_two

GO
ALTER TABLE [dbo].[data_tb_02]  WITH CHECK ADD  CONSTRAINT [FK_data_tb_02_data_tb_01] FOREIGN KEY([id_tb_01])
REFERENCES [dbo].[data_tb_01] ([id])
GO
ALTER TABLE [dbo].[data_tb_02] CHECK CONSTRAINT [FK_data_tb_02_data_tb_01]
GO
/****** Object:  StoredProcedure [dbo].[usp_my_procedure]    Script Date: 20/02/2019 11:21:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[usp_my_procedure]
	-- Add the parameters for the stored procedure here
	@Param1 int,
	@Param2 int OUTPUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DECLARE @NewIdCreated int;


	--SELECT * FROM data_tb_01;

	INSERT INTO data_tb_01(field_one,field_two) VALUES (CONVERT(VARCHAR(100),NEWID()),CONVERT(VARCHAR(255),NEWID()));

	SET @NewIdCreated = (SELECT @@IDENTITY AS 'id');

	INSERT INTO data_tb_02(field_three,field_four,id_tb_01) VALUES (CONVERT(VARCHAR(50),NEWID()),CONVERT(VARCHAR(100),NEWID()),@NewIdCreated),
																   (CONVERT(VARCHAR(50),NEWID()),CONVERT(VARCHAR(100),NEWID()),@NewIdCreated);

	SELECT * FROM uv_my_view WHERE id = @NewIdCreated;
	RETURN
END
GO
